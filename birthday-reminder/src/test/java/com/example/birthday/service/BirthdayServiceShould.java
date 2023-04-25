//package com.example.birthday.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.example.birthday.Service.BirthdayServiceImpl;
//import com.example.birthday.dto.Employee;
//import com.example.birthday.repositories.BirthdayRepository;
//
//
//
//@ExtendWith(MockitoExtension.class)
//class BirthdayServiceImplShould {
//
//    @Mock
//    private BirthdayRepository birthdayRepository;
//
//    @InjectMocks
//    private BirthdayServiceImpl birthdayService;
//
//
//    private Employee employee;
//
//    @BeforeEach
//    public void setup() {
//
//       employee= Employee.builder()
//                .dob(LocalDate.of(2002, 2, 2))
//                .team_id(1)
//                .emp_name("jane")
//                .emp_id(1001)
//                .username("test@gmail.com")
//                .password("waes")
//                .role("admin")
//                .build();
//
//    }
//
//    @DisplayName("test for register employee")
//    @Test
//    public void givenEmployee_whenRegisterEmployee_thenReturnBoolean() {
//
//
//
//        given(birthdayRepository.findById(employee.getEmp_id()))
//                .willReturn(Optional.empty());
////        
////        assertAll(
////        		()-> assertEquals("jane", employee.getEmp_name()),
////        		()->assertEquals(LocalDate.of(2002, 2, 2), employee.getDob()),
////        		()->assertEquals(1,employee.getTeam_id()),
////        		()->assertEquals(1001, employee.getEmp_id()),
////        		
////        		()->assertEquals("waes", employee.getPassword()),
////        		()->assertEquals("admin", employee.getRole()),
////        		()->assertEquals("test@gmail.com", employee.getUsername())
////        		
////        		);
////        
//        
//        given(birthdayRepository.save(employee))
//                .willReturn(employee);
//
//        System.out.println(birthdayRepository);
//        System.out.println(birthdayService);
//
//        Boolean saved = birthdayService.registerEmp(employee);
//        System.out.println(saved);
//
//        assertThat(saved).isTrue();
//
//
//    }
//
//    
//    @DisplayName("test for register employee whose emp_id already exist check for exception ")
//    @Test
//    public void givenEmployee_whenRegisterEmployee_thenReturnFalse() {
//
//
//
//        given(birthdayRepository.findById(employee.getEmp_id()))
//                .willReturn(Optional.of(employee));
//        given(birthdayRepository.save(employee))
//        .willReturn(employee);
//        System.out.println(birthdayRepository);
//        System.out.println(birthdayService);
//
//        Boolean newEmp = birthdayService.registerEmp(employee);
//        System.out.println(newEmp);
//
//        assertThat(newEmp).isFalse();
//       
//    }
//    
//    @DisplayName("test for read employee given its id")
//    @Test
//    @Disabled
//    public void givenEmployeeId_whenReadEmployee_thenReturnEmployee() {
//    	given(birthdayRepository.findById(1001))
//    	.willReturn(Optional.of(employee));
//    	
//    	//assertThat(emplo)
//    	
//    	
//    }
//    
//	@Test
//	void testReadEmp() {
//
//		Employee emp = birthdayRepository.findById(1001).get();
//		assertThat(emp.getEmp_id()).isEqualTo(1001);
//	}
//
//
//
//    
//    
//    
//
//}
