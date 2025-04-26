package com.StudentMangementSystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentMangementSystem.entity.Student;
import com.StudentMangementSystem.repository.StudentRepository;
import com.StudentMangementSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService {
	
     @Autowired
	StudentRepository Studentrepository;
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		System.out.println("New List Initial Size: "+studentList.size());
		studentList = Studentrepository.findAll(); 
		if(studentList.size() > 0) {
			System.out.print("Number of Students are present are."+studentList.size());
			System.out.print("Students are"+studentList.toString());
			
		}else {
			System.out.print("No Students are present."+studentList.size());
		}
		return studentList;
	}

	@Override
	public Student saveStudent(Student student) {
		 Student savedStudent = Studentrepository.save(student);

		 System.out.println("Student saved successfully: " + savedStudent);
		return savedStudent;

		// TODO Auto-generated method stub
		//return Studentrepository.save(student);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> optionalStudent=Studentrepository.findById(id);
		
			if(optionalStudent.isPresent()) {
					Object s = optionalStudent.isPresent();
					System.out.println("Student found:" + optionalStudent.get());
					return optionalStudent.get();
			}else {
				System.out.println("Student not found");
				return null;
				
			}
		
		//return Studentrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		Studentrepository.deleteById(id);
		
	}
      
}
