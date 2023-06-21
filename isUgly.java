package 电信机试题;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
//        new Solution().sortEmp();
        System.out.println(new Solution().check(153));
    }

    /*
        丑数
     */
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 == 0) {
            return isUgly(n / 2);
        } else if (n % 3 == 0) {
            return isUgly(n / 3);
        } else if (n % 5 == 0) {
            return isUgly(n / 5);
        }
        return false;
    }

    /*
        尼姆博弈
     */
    public boolean Nim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }

    /*
        员工排序
     */
    public void sortEmp() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Employee[] arr = new Employee[num];
        scanner.nextLine();//吸收回车
        for (int i = 0; i < num; i++) {
            String[] s = scanner.nextLine().split(" ");
            String name = s[0];
            int level = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);
            float salary = Float.parseFloat(s[3]);
            arr[i] = new Employee(name, level, time, salary);
        }
        Arrays.sort(arr);
        for (Employee employee :
                arr) {
            System.out.println(employee.toString());
        }
    }

    /*
        水仙花数
     */
    public boolean check(int n) {
        int temp = n;
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 3);
            n /= 10;
        }
        return sum == temp;
    }
    /*
        字符串查找和比较
     */


}

class Employee implements Comparable {
    public String name;
    public int level;
    public int time;
    public float salary;

    public Employee(String name, int level, int time, float salary) {
        this.name = name;
        this.level = level;
        this.time = time;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + level + " " + time + " " + salary;
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        if (this.level > e.level) {
            return -1;
        }
        if (this.level == e.level && this.salary < e.salary) {
            return -1;
        }
        if (this.salary == e.salary && this.time > e.time) {
            return -1;
        }
        return 0;
    }

    /*
6
张三 3 3 3000
李四 3 4 3000
王五 3 3 4000
赵六 4 3 3000
陆奇 4 4 4000
闰八 4 4 3980.99
     */

}
