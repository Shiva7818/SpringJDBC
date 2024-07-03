package com.spring.jdbcNotPreferred;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("My pgm started .......");
//        spring jdbc => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        
//        insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        
//        fire query
        int res = template.update(query,23,"Naman Sharma","B.S.R");
        
        System.out.println("number of record inserted : "+res);
        
        
    }
}
