JPA and Hibernate
---------------------------------------------------------------------

    Lab Setup
    ---------------------------------------------------------
        JDK 1.8
        Eclipse for JavaEE latest
        MySQL 8 or above

    ORM
    ---------------------------------------------------------

        Object Relational Mapping

                                        OOP                                     RDBMS
                                        ------------------------------------------------------------------------------------
        Entity Def                      Class                                   Table
        Entity                          object                                  row/record/tuple
        Field                           field/data member                       col/attribute
        Behaviours                      methods                                 ------

        Associatons
         Is A (Generalization)          Inheretence                             

                                        Employee eid,name,sal                   Single-Table
                                         | - ContractEmployee duration              AllEmps  eid,name,sal,duration,allo,etype
                                         | - Manager allowence

                                                                                Join-Table
                                                                                    Emps    eid,name,sal
                                                                                    cEmps   eid,duration
                                                                                    Mgrs    eid,allowence

                                                                                Table-Per-Entity
                                                                                    Emps    eid,name,sal
                                                                                    cEmps   eid,name,sal,duration
                                                                                    Mgrs    eid,name,sal,allowence

         Has A
            Composition                 class Address {                         Emps    eid,name,sal,line1,line2,city,state
                                            String firstLine;
                                            String secondLine;
                                            String city;
                                            String state;
                                        }

                                        class Employee {
                                            Long eid;
                                            String name;
                                            Double sal;
                                            Address address;
                                        }
            Aggregation
                One2One                 class Employee {                        Emps        eid,name,sal
                                            Long eid;                           Accounts    acnum,bank,branch,ifsc,eid
                                            String name;
                                            Double sal;
                                            BankAccount salAccount;             Emps        eid,name,sal,acnum
                                        }                                       Accounts    acnum,bank,branch,ifsc

                                        class BankAccount {
                                            String accNum;
                                            String bankName;
                                            String branch;
                                            String ifscCode;
                                            Employee holder;
                                        }

                One2Many                class Department {                      Depts   did,title
                Many2One                    Long did;                           Emps    eid,name,sal,did
                                            String title;
                                            Set<Employee> emps;
                                        }

                                        class Employee {
                                            Long eid;
                                            String name;
                                            Double sal;
                                            Department dept;
                                        }

                Many2Many               class Project {                        Prjs     pcode,title
                                            Long projCode;                     Emps     eid,name,sal
                                            String title;                      Prj_Emp  pcode,eid 
                                            Set<Employee> team;
                                        }

                                        class Employee {
                                            Long eid;
                                            String name;
                                            Double sal;        
                                            Set<Project> projests;
                                        }


                                        class Project {                        Prjs     pcode,title
                                            Long projCode;                     Emps     eid,name,sal
                                            String title;                      conts    pcode,eid,role,joindate,rvlDate
                                            Set<Contribution> contributions;
                                        }

                                        class Employee {
                                            Long eid;
                                            String name;
                                            Double sal;        
                                            Set<Contribution> contributions;
                                        }

                                        class Contribution {
                                            Project project;
                                            Employee contributor;
                                            String role;
                                            LocalDate joinDate;
                                            LocalDate relevingDate;
                                        }