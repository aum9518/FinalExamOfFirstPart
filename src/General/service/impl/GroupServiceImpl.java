package General.service.impl;

import General.db.Database;
import General.model.Group;
import General.service.GroupService;

import java.util.*;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {
    Database database = new Database();
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
        List<Database>databases = new ArrayList<>();
        database.getGroups().stream().toList().forEach(x-> x.getId());

        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group>list = database.getGroups().stream().toList();
        return list;
    }

    @Override
    public String updateGroupName(int id, String groupName) {
        return null;
    }

    @Override
    public List<Group> filterByYear(int year, String ascDesc) {
        return null;
    }

    @Override
    public List<Group> sortGroupByYear(String ascDesc) {
        List<Group>groups = database.getGroups().stream().sorted(Comparator.comparing(Group::getYear))
                .collect(Collectors.toList());
        return groups;
    }

    @Override
    public void deleteGroupById(int id) {
        List<Group>groups = database.getGroups().stream().collect(Collectors.toList());
        for (Group g:groups) {
            if (g.getId()==id){
                groups.remove(g);
            }
        }

    }
}
