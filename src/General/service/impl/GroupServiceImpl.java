package General.service.impl;

import General.db.Database;
import General.model.Group;
import General.service.GroupService;

import java.util.*;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {
    Database database = new Database(new ArrayList<>(),new ArrayList<>());
    @Override
    public String addNewGroup(Group group) {
       /* Group group1 = new Group();
        System.out.println("Enter group name: ");
        String groupName = new Scanner(System.in).nextLine();
        group1.setName(groupName);
        System.out.println("Enter description: ");
        String description = new Scanner(System.in).nextLine();
        group1.setDescription(description);
        System.out.println("Enter year: ");
        int year = new Scanner(System.in).nextInt();
        group1.setYear(year);*/
        database.getGroups().add(group);
        return "Successfully created!";
    }

    @Override
    public String getGroupById(int id) {
      Optional<Group>group = database.getGroups().stream().filter(x-> x.getId()==id).findFirst();

      if (group.isEmpty()){
          return "Not found";
      }else {
          return group.toString();
      }

    }

    @Override
    public List<Group> getAllGroups() {
        return   database.getGroups().stream().toList();

    }

    @Override
    public String updateGroupName(int id, String groupName) {
        database.getGroups().stream().filter(x-> x.getId()==id)
                .toList().get(id-1).setName(groupName);
        return "Updated!";
    }

    @Override
    public List<Group> filterByYear(int year, String ascDesc) {
        if (ascDesc.equals("asc")){
          List<Group>list=  database.getGroups().stream().filter(x-> x.getYear()>year).toList();
            return list;
        } else if (ascDesc.equals("desc")) {
            List<Group>list1=database.getGroups().stream().filter(a->a.getYear()<year).toList();
            return list1;
        }
        return null;
    }

    @Override
    public List<Group> sortGroupByYear(String ascDesc) {
      if (ascDesc.equals("asc")){
          List<Group>list = database.getGroups().stream().sorted(Comparator.comparing(Group::getYear)).toList();
          return list;
      } else if (ascDesc.equals("desc")) {
          List<Group>list1 = database.getGroups().stream().sorted(Comparator.comparing(Group::getYear).reversed()).toList();
          return list1;
      }
        return null;
    }

    @Override
    public void deleteGroupById(int id) {
        System.out.println(database.getGroups().stream().filter(x -> x.getId() != id)
                .collect(Collectors.toList()));

    }
}
