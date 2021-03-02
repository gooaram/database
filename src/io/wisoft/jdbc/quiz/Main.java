package io.wisoft.jdbc.quiz;

public class Main {

    public static void main(String[] args) {
        DepartmentService departmentService = new DepartmentService();
        EmployeeService employeeService = new EmployeeService();
        DramaService dramaService = new DramaService();

        System.out.println("Q1. HNU 엔터테인먼트 부서의 코드, 이름, 위치를 검색하시오.");
        departmentService.departmentFindAll();
        System.out.println();

        System.out.println("Q2. HNU 엔터테인먼트 연예관계자의 코드, 이름, 관리자, 급여를 검색하시오.");
        employeeService.employeeFindAll();
        System.out.println();

        System.out.println("Q3. HNU-E에서 제작한 드라마의 코드, 이름을 검색하시오.");
        dramaService.dramaFindCodeAndName();
        System.out.println();

        System.out.println("Q4. 드라마 방영사가 KBC 이거나 SBC 인 드라마를 검색하시오.");
        dramaService.dramaProductFindKBCAndSBC();
        System.out.println();

        System.out.println("Q5. 모든 드라마 제작사를 중복없이 검색하시오.");
        dramaService.dramaFindProduct();
        System.out.println();

        System.out.println("Q6. 연예관계자들의 급여의 총합과 평균 급여액을 계산하시오.");
        employeeService.employeeFindSalary();
        System.out.println();

        System.out.println("Q7. 방영일자가 아직 확정되지 않은 드라마의 이름을 검색하시오.");
        dramaService.dramaFindName();
        System.out.println();

        System.out.println("Q8. 연예관계자에 대해 연예관계자의 이름과 직속 상사의 이름을 검색하시오.");
        employeeService.employeeFindName();
        System.out.println();

        System.out.println("Q9. 연예관계자에 대해 이름과 급여를 출력하고, 급여의 내림차순으로 정렬하시오. 단, 동일 급여일 때는 이름의 오름차순으로 정렬하시오.");
        employeeService.employeeFindSalaryAll();
        System.out.println();

        System.out.println("Q10. 모든 연예관계자를 직급별로 그룹화하고, 평균 급여액이 5000 이상인 직급에 대해 연예 관계자의 직급, 평균 급여액, 최소 급여액, 최대 급여액을 검색하시오.");
        employeeService.employeeFindSal();
        System.out.println();

        System.out.println("Q11. 모든 연예관계자의 평균 급여액보다 많은 급여를 받는 연예관계자의 이름과 급여를 검색하라.");
        employeeService.employeeFindAboveAvgSal();
        System.out.println();

        System.out.println("Q12. 방영일자가 확정되지 않은 드라마의 방영일자가 2013-05-01로 편성되었습니다. 알맞게 변경하시오.");
        dramaService.dramaUpdateOpdate();
        System.out.println();

        System.out.println("Q13. 연예관계자 김수현 씨가 대리에서 실장으로 승진하고 급여가 20% 증가되었습니다. 알맞게 변경하시오.");

        System.out.println();

        System.out.println("Q14. 우리 회사에 한 명의 임원이 등록되었습니다. 코드는 E903, 이름은 손진현, 관리자는 E901, 급여는 4000입니다. 알맞게 등록하시오.");
        employeeService.employeeInsertData();
        System.out.println();

        System.out.println("Q15. 연예관계자인 손진현님이 퇴직했습니다. 연예관계자 목록에서 제거하시오.");
        employeeService.employeeDeleteData();
        System.out.println();

    }

}
