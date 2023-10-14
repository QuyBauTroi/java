package Bai7_1;




public class Main {
    public static void main(String[] args){
        biZStudent[] students = new biZStudent[3];
        students[0] = new biZStudent("Nguyen","Cong an phuong",1,4);
        students[1] = new biZStudent("Yen","Ki su",6,6);
        students[2] = new biZStudent("Bong","Giao vien",4,1);


        itStudent[] students1 = new itStudent[3];
        students1[0] = new itStudent("Quy","Superman",10,10,10);
        students1[1] = new itStudent("Quynh","IOT",4,7,8);
        students1[2] = new itStudent("Quyet","FontEnd",1,6,6);


        for (biZStudent sv : students) {
            sv.printInfo();
        }
        for (itStudent sv1 : students1){
            sv1.printInfo();
        }
    }
}
