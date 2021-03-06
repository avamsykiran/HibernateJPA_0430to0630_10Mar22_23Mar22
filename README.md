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

    Java Approach to ORM - JPA (Java Persistence API) + JTA (Java Transaction API)
    ------------------------------------------------------------------------

            specifications                      implementations
            JDBC                                database drivers
            Servlets API                        web servers like CATALINA of Tomcat
            JPA and JTA                         thrid party implmentors like
                                                        Hibernate
                                                        TopLink
                                                        Eclipse ORM ....etc

        JPA Configuaration              ${project.basedir}/src/META-INF/persistence.xml
            1. db driver
            2. db dialect
            3. db url, uid and pwds
            4. jpa provider (jpa implmentation)
            5. any other jpa provider related customizations....

        JPA Mapping Annotations

            @Entity             class level
            @Embedable          class level
            @Table              class level

            @Id                 field level     marks primary key
            @GeneratedValue     field level     strategy 'AUTO/INCREMENT/SEQUENCE'
            @Column             field level     name,unique,nullable ..etc
            @Transiant          field level     skip a field from being mapped with any column
            @Enumerated         field level     
            @EmbededId          field level     used to mark composite keys

                                                @Embedable
                                                class StudentId {
                                                    private Integer roll;
                                                    private String clazz;
                                                    private String section;
                                                }

                                                @Entity
                                                class Student{
                                                    @EmbededId
                                                    private StudentId studentId;
                                                    ...............
                                                }

            @Inheretence        class level     strategy 'SINGLE_TABLE/JOINED_TABLE/TABLE_PER_CLASS'
            @DiscriminatorColumn
            @DiscriminatorValue

            @Embeded            field level     for composition

            @OneToOne           field level     for one to one aggregation
            @OneToMany          field level     for one to many aggregation
            @ManyToOne          field level     for many to one aggregation
            @ManyToMany         field level     for many to many aggregation

            @JoinColumn         field level
            @JoinTable          field level


        Fetch Strategies
            LAZY
            EAGER

        Cascading Strategies
            NONE
            ALL
            PERSIST
            MERGE
            DELETE
            DETACH
            REFRESH

        Case Study
        ----------------------------------------------------------------------------------

            A Direct-to-Home (tatasky or dish...etc) System

            1. A consuemr is represented by his mobile number.
            2. While registration we need to record the name,address and mobile number
            3. Each Channel is represented by a channel code and detials like channel name
                monthly fee are needed
            4. A consumer can have more than one subscription
            5. Each subscription can have a group of packages or individual channels.
            6. Each subscription will have a activation date and validity date.
            7. A package is a group of a few channels.
            
            Consumer
                ---OneTOMany-->> <<--ManyToOne--- Subscription

            Channel
                ---OneTOMany-->> <<--ManyToOne--- PackazeItem
                ---OneTOMany-->> <<--ManyToOne--- SubscriptionItem

            Packaze
                ---OneTOMany-->> <<--ManyToOne--- PackazeItem
                ---OneTOMany-->> <<--ManyToOne--- SubscriptionItem

            Subscription
                ---OneTOMany-->> <<--ManyToOne--- SubscriptionItem


        JPQL - Java Persistence Query Language                     SQL
            uses class names and field names                            uses table names and column names

            SELECT e FROM Employee e                                    SELECT * FROM emps
            SELECT e.name,e.mailId FROM Employee e                      SELECT ename,mail_id FROM emps
            
            SELECT e.salary FROM Employee e                             SELECT e.sal 
            WHERE e.dept.title="ACCOUNTS"                               FROM   emps e INNET JOIN depts d 
                                                                        ON     e.dept_no = d.dept_no
                                                                        WHERE  d.title='ACCOUNTS'

        JPA api
            Persistence
                .createEntityManagerFactory("PU_NAME")
                    EntityManagerFactory
                        ::createEntityManager()
                            EntityManager
                                ::find(Entity.class,ID_VALUE) : Entity
                                ::persist(entity) : Entity                   INSERT
                                ::merge(entity)   : Entity                  UPDATE
                                ::remove(entity)  : void                    DELETE
                                ::createQuery("JPQL QRY") : Query
                                ::createQuery("JPQL QRY",Entity.class) : TypedQuery
                                ::getTransaction() : EntityTransaction
            
            EntityTransaction
                ::begin()
                ::commit()
                ::rollback()

            Query
                ::getResults() : List
                ::getStream() : Stream
            
            TypedQuery
                ::getResults() : List<Entity>
                ::getStream() : Stream<Entity>

        Hibernate api
            SessionFactory
                .createSession()
                    Session
                        ::get(entity.class,id_value) : Entity
                        ::load(entity.class,id_value) : Entity
                        ::save(entity)
                        ::update(entity)
                        ::saveOrUpdate(entity)
                        ::delete(entity)
                        ::createQuery("HQL QRY") : Query
                        ::createQuery("HQL QRY",Entity.class) : TypedQuery
                        ::beginTransaction() : Transaction

            hibernate.cfg.xml

            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE hibernate-configuration PUBLIC 
            "-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
            "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
            <hibernate-configuration>
                <session-factory>
                <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
                <property name="connection.url">jdbc:mysql://localhost:3306/jpaHibDb?createDatabaseIfNotExist=true</property>
                <property name="connection.username">root</property>
                <property name="connection.password">password</property>
                <property name="connection.pool_size">3</property>
                <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
                <property name="current_session_context_class">thread</property>
                <property name="show_sql">true</property>
                <property name="format_sql">true</property>
                <property name="hbm2ddl.auto">update</property>
                
            </session-factory>
            </hibernate-configuration>

            // SessionFactory in Hibernate 5 example
            Configuration config = new Configuration();
            config.configure();
            // local SessionFactory bean created
            SessionFactory sessionFactory = config.buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
