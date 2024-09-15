package com.alexeyprojects.course.services;

import com.alexeyprojects.course.entities.User;
import com.alexeyprojects.course.repositories.UserRepository;
import com.alexeyprojects.course.services.exceptions.DatabaseException;
import com.alexeyprojects.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //Caso o optional esteja vazio, lança uma exceção.
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        Optional<User> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new ResourceNotFoundException(id);
        }else {
            try{
                repository.deleteById(id);
            }catch (DataIntegrityViolationException e){
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    public User update(Long id, User user){
        try{
            User entity = repository.getReferenceById(id);  //Preparando um objeto monitorado
            updateData(entity, user);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
