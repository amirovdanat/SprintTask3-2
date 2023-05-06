package SprintTask24;

import java.util.ArrayList;

public class DBManager24 {
    public static ArrayList<Model24> dbm=new ArrayList<>();

    static {
            dbm.add(new Model24(1L, "Create web app on Java EE", "Create web app on Java EE", "23.10.2021", false));
            dbm.add(new Model24(2L, "222Create web app on Java EE", "222Create web app on Java EE", "23.10.2021", false));
    }

    public static void addTask(Model24 obj){
        obj.setId((long)dbm.size()+1);
        dbm.add(obj);
    } //этот метод добавляет новую задачу в список

    public static Model24 getTask(Long id){
//    for (Model24 obj : dbm){
//        if (obj.getId()==id){
//            return obj;
//        }
//        return  null;
//
//    }
        return dbm.stream().filter(obj->obj.getId().equals(id)).findFirst().orElse(null);
    } // этот метод возвращает объект задачи по id

    public static ArrayList<Model24> getAllDbm(){
        return dbm;
    } //этот метод возвращает список всех задач

    public static void deleteTask(Long id){

//        for (int i=0;i< dbm.size();i++) {
//            if (dbm.get(i).getId().equals(id)){
//                dbm.remove(i);
//                return;
//            }
//
//        }

        dbm.removeIf(obj->obj.getId().equals(id));

    } //этот метод удаляет задачу из списка по id

    public  static void updateTask(Long id, Model24 obj){
//        for (int i = 0; i < dbm.size(); i++) {
//            if (dbm.get(i).getId().equals(id)){
//                dbm.set(i,obj);
//            }
//        }
     //   dbm.stream().map(o -> o.getId().equals(id) ? obj : o).collect(Collectors.toList());
    }
}

