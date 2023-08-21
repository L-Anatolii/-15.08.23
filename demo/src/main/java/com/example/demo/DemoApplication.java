package com.example.demo;

import com.example.demo.entity.AdressObject;
import com.example.demo.entity.Relationship;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static List<AdressObject> tableOfAddressObjects() throws IOException {
		String file = Files.readString(Path.of("C:\\Users\\Anato\\Desktop\\Тестовое задание от 21.08.23\\demo\\src\\main\\resources\\AS_ADDR_OBJ.txt"));
		XmlMapper xmlMapper = new XmlMapper();
		AdressObject[] array = xmlMapper.readValue(file, AdressObject[].class);
		return (Arrays.stream(array).collect(Collectors.toList()));
	}

	public static List<Relationship> tableOfRelationship() throws IOException {
		String file = Files.readString(Path.of("C:\\Users\\Anato\\Desktop\\Тестовое задание от 21.08.23\\demo\\" +
				"src\\main\\resources\\AS_ADM_HIERARCHY.txt"));
		XmlMapper xmlMapper = new XmlMapper();
		Relationship [] array = xmlMapper.readValue(file, Relationship[].class);
		return (Arrays.stream(array).collect(Collectors.toList()));
	}

	public static void main(String[] args) throws IOException, ParseException {
		DemoApplication addresses = new DemoApplication();
		addresses.filter("2010-01-01", Arrays.asList(1422396, 1450759, 1449192, 1451562));

		addresses.outPrintFullAddress();//не самый быстрый способ, но рабочий

	}

	public void filter(String stringDate, List<Integer> objectIds) throws IOException, ParseException {
		Date convertedDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
		tableOfAddressObjects().stream()
				.filter(x -> x.getSTARTDATE().compareTo(convertedDate) <= 0 && x.getENDDATE().compareTo(convertedDate) >= 0)
				.filter(x -> objectIds.contains(x.getOBJECTID()))
				.forEach(x -> System.out.println(x.getOBJECTID() + ": " + x.getTYPENAME() + " " + x.getNAME()));
	}


	public void outPrintFullAddress() throws IOException {
		List<List<Integer>> fullListIdAddress = listIdAddressWithRelationship(tableOfRelationship());

		//список id объектов которые содержать в поле "проезд"
		List<Integer> idAddressContainsPassage = tableOfAddressObjects().stream()
				.filter(x -> x.getTYPENAME().equals("проезд"))
				.map(AdressObject::getOBJECTID)
				.collect(Collectors.toList());

		// Cписок полных адрессов со всеми у кого TypeName = "проезд"
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < fullListIdAddress.size(); i++) {
			if (containsAny(fullListIdAddress.get(i), idAddressContainsPassage)) {
				Collections.reverse(fullListIdAddress.get(i));
				list.add(fullListIdAddress.get(i));
			}
		}

		//Вывод полных адрессов cо словом "проезд"
		for (List<Integer> array : list) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < array.size(); j++) {
				for(int k = 0; k< tableOfAddressObjects().size(); k++){
					if(array.get(j).equals(tableOfAddressObjects().get(k).getOBJECTID())){
						builder.append(tableOfAddressObjects().get(k).getTYPENAME()).
								append(" ").
								append(tableOfAddressObjects().get(k).getNAME()).
								append(" ");
					}
				}
			}
			System.out.println(builder);
		}
	}

	public List<List<Integer>> listIdAddressWithRelationship(List<Relationship> table) throws IOException {
		List<Relationship> activeRelationship = table.stream().
				filter(x -> x.getISACTIVE() == 1)
				.collect(Collectors.toList());

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < activeRelationship.size(); i++) {
			List<Integer> innerList = new ArrayList<>();
			getIdAddress(activeRelationship.get(i).getOBJECTID(), activeRelationship, innerList);
			list.add(innerList);
		}
		return list;
	}

	public int getIdAddress(int idChild, List<Relationship> relationships, List<Integer> list) {
		for (Relationship currentEntity : relationships) {
			Integer idEntity = currentEntity.getOBJECTID();
			int idParent = currentEntity.getPARENTOBJID();

			if (idEntity.equals(idChild)) {
				if(list.isEmpty()){
					list.add(idEntity);
				}
				list.add(idParent);
				getIdAddress(idParent, relationships, list) ;
				return idParent;
			}
		}
		return -1;
	}

	public boolean containsAny(List<Integer> firstList, List<Integer> secondList ){
		for (Integer e1 : firstList) {
			for (Integer e2 : secondList) {
				if (e1.equals(e2)) {
					return true;
				}
			}
		}
		return false;
	}
}
