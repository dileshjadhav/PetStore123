package com.itvedant.petstore123.Services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    // @Autowired
   // private UserRepository repository;

   //  private Map<Integer,user> userMap = new HashMap<>();
   //  private AtomicInteger atomic = new AtomicInteger(); 
 

   //  //we are using CRUD operation without using constructor.

   //  //creating
   //  public user addUser(user newUser){
   //     // newUser.setId(atomic.incrementAndGet());
   //      //userMap.put(newUser.getId(), newUser);
   //      //return newUser;
   //      return repository.save(newUser);
   //   } 

   //   //reading

   //   public Iterable<user> getAllUsers(){
   //      //return userMap.values();
   //      return repository.findAll(); 
   //   }

   //   public user getUserById(Integer id){
   //      //return userMap.get(id);
   //      // get() returns the user object if the record of the user exists in the DB
   //      //get() throw an exception NOsuchElementException if the record of the user does
   //      //orElse()  returns the user object if the record of the user exists in the DB
   //      //orElse() returns the value mentioned as paramenter like here it is Null
   //      return repository.findById(id).orElse(null);
   //   }

   //   //updating

   //   public user updatedUser(Integer id,user u){
   //     // u.setId(id);
   //     // userMap.put(id,u);
   //      //return u;
   //       u.setId(id);
   //      return repository.save(u);       //hibersnte will not see id thsts why we are creating set id. only update respective id.

   //   }

   //   //delete

   //   public String deleteUser(Integer id){
   //      //userMap.remove(id);
   //      repository.deleteById(id);
   //      return "Deleted sucessfully";


   //   }

    
}
