package io.wisoft.jdbc;

public class Main {

    public static void main(String[] args) {
        StudentSelectService selectService = new StudentSelectService();
        Student student = new Student();
        Student[] students = new Student[8];

        for (int i = 0; i<students.length; i++) {
            students[i] = new Student();
        }

        StudentInsertService insertStudent = new StudentInsertService();

        System.out.println("학번이 20110401" +
                "이고, 이름이 이순신인 학생을 추가합니다.");
        student.setNo("20110401");
        student.setName("이순신");
        insertStudent.insertStudent(student);
        System.out.println();

        System.out.println("학번이 20110501이고, 이름이 이율곡인 학생을 추가합니다.");
        System.out.println("학번이 20110601이고, 이름이 이수일인 학생을 추가합니다.");
        System.out.println("학번이 20110701이고, 이름이 심순애인 학생을 추가합니다.");
        System.out.println("학번이 20110801이고, 이름이 임꺽정인 학생을 추가합니다.");

        students[0].setNo("20110501");
        students[0].setName("이율곡");

        students[1].setNo("20110601");
        students[1].setName("이수일");

        students[2].setNo("20110701");
        students[2].setName("심순애");

        students[3].setNo("20110801");
        students[3].setName("임꺽정");

        insertStudent.insertStudentMulti(students);
        System.out.println();

        System.out.println("학번이 20110901이고, 이름이 이상훈인 학생을 추가합니다.");
        System.out.println("학번이 20111001이고, 이름이 강동희인 학생을 추가합니다.");
        System.out.println("학번이 20111101이고, 이름이 김호성인 학생을 추가합니다.");
        System.out.println("학번이 20111201이고, 이름이 김정준인 학생을 추가합니다.");

        students[0].setNo("20110901");
        students[0].setName("이상훈");

        students[1].setNo("20111001");
        students[1].setName("강동희");

        students[2].setNo("20111101");
        students[2].setName("김호성");

        students[3].setNo("20111201");
        students[3].setName("김정준");

        insertStudent.insertStudentMultiBatch(students);
        System.out.println();

        System.out.println("전체 학생을 검색합니다.");
        selectService.getStudentAll();
        System.out.println();

        System.out.println("학번 20110101 학생을 검색합니다.");
        String studentNo = "20110101";

        selectService.getStudentByNo(studentNo);
        System.out.println();

        System.out.println("이름 일지매 학생을 검색합니다.");
        String studentName = "일지매";

        selectService.getStudentByName(studentName);
        System.out.println();

        System.out.println("생일 1991-02-28 학생을 검색합니다.");
        String studentBirthday = "1991-02-28";

        selectService.getStudentByBirthday(studentBirthday);
        System.out.println();

        //delete, update 구현하기

        StudentUpdateService updateStudent = new StudentUpdateService();

        System.out.println("학번이 20110401인 학생의 생일을 1990-03-21로 변경합니다.");
        updateStudent.updateStudentBirthday("20110401", "1990-03-21");
        System.out.println();

        System.out.println("학번이 20110501인 학생의 생일을 1990-03-01으로 변경합니다.");
        System.out.println("학번이 20110601인 학생의 생일을 1990-04-01으로 변경합니다.");
        System.out.println("학번이 20110701인 학생의 생일을 1990-05-01으로 변경합니다.");
        System.out.println("학번이 20110801인 학생의 생일을 1990-06-01으로 변경합니다.");
        System.out.println("학번이 20110901인 학생의 생일을 1990-07-01으로 변경합니다.");
        System.out.println("학번이 20111001인 학생의 생일을 1990-08-01으로 변경합니다.");
        System.out.println("학번이 20111101인 학생의 생일을 1990-09-01으로 변경합니다.");
        System.out.println("학번이 20111201인 학생의 생일을 1990-10-01으로 변경합니다.");

        students[0].setNo("20110501");
        students[0].setBirthday("1990-03-21");

        students[1].setNo("20110601");
        students[1].setBirthday("1990-04-21");

        students[2].setNo("20110701");
        students[2].setBirthday("1990-05-21");

        students[3].setNo("20110801");
        students[3].setBirthday("1990-06-21");

        students[4].setNo("20110901");
        students[4].setBirthday("1990-07-21");

        students[5].setNo("20111001");
        students[5].setBirthday("1990-08-21");

        students[6].setNo("20111101");
        students[6].setBirthday("1990-09-21");

        students[7].setNo("20111201");
        students[7].setBirthday("1990-10-21");

        updateStudent.updateStudentBirthdayMultiBatch(students);
        System.out.println();

        StudentDeleteService deleteStudent = new StudentDeleteService();

        System.out.println("학번이 20110401인 학생을 목록에서 제거합니다.");
        deleteStudent.deleteStudentNo("20110401");
        System.out.println();

        System.out.println("학번이 20110501인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20110601인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20110701인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20110801인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20110901인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20111001인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20111101인 학생을 목록에서 제거합니다");
        System.out.println("학번이 20111201인 학생을 목록에서 제거합니다");

        students[0].setNo("20110501");
        students[1].setNo("20110601");
        students[2].setNo("20110701");
        students[3].setNo("20110801");
        students[4].setNo("20110901");
        students[5].setNo("20111001");
        students[6].setNo("20111101");
        students[7].setNo("20111201");

        deleteStudent.deleteStudentNoMultiBatch(students);
        System.out.println();
    }

}