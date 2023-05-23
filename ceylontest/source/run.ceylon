
abstract class Person() of Student | Worker {}

abstract class Student() of PG | UG extends Person() {}
class Worker() extends Person() {}

class PG() extends Student() {}
class UG() extends Student() {}

class Robot() {}

void test(Integer | String x) {
    switch (x)
      case (is Integer) {}
      case (is String) {}
      // case (is Integer&String) {}
}

void testThesis() {
//    Student | Person human = PG();
//
//    switch (human)
//        case (is Person)  {}
//        case (is Student) {}

    Person | Robot hybrid = Robot();

    switch (hybrid)
        case (is Person)  {}
        case (is Robot)   {}
}

class Test1() {}
class Test2() {}

//class Test10 satisfies Test1&Test2 {}

class Test3() extends Test2() {}
class Test4() extends Test2() {}

void test2() {
    Test1|Test2 x = Test1();
    switch (x)
        case (is Test1) {}
        case (is Test2) {}
}

//void test3() {
//    Test1|Test2 x = Test1();
//    switch (x)
//        case (is Test1) {}
//        case (is Test3) {}
//        case (is Test4) {}
//}

abstract class Test5() of Test6 | Test7 {}

class Test6() extends Test5() {}
class Test7() extends Test5() {}

void test4() {
    Test2|Test5 x = Test2();
    switch (x)
        case (is Test2) {}
        case (is Test6) {}
        case (is Test7) {}
}

void test6(Test6 | Test7 x) {

}

void test7() {
    Test5 temp = Test6();
    test6(temp);
}

void test5() {
    Test2|Test5 x = Test2();
    switch (x)
    case (is Test2) {}
    case (is Test5) {}
    // case (is Test7) {}
}


/*
   Research on parallel compilation with disjointness
 */

shared void run () {
    print("Hello World");
}