package com.itvedant.petstore123.Services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.petstore123.FileStorageProperties;
import com.itvedant.petstore123.Entities.Product;
import com.itvedant.petstore123.Repository.ProductRepository;

//import jakarta.persistence.criteria.Path;
@Service //object of this class is automatically created as soon as application start.
public class ProductService {   //service class is will contains the business logic which will be accesseed from the controller
    //key  //value pair
    
     @Autowired
    private ProductRepository repository;
    //setting the location where the uploads to be the done
    //and the file from the download 

    private final java.nio.file.Path rootLocation;

    public ProductService(FileStorageProperties properties){
        this.rootLocation = Paths.get(properties.getUploadDir());

        try{
            Files.createDirectories(rootLocation);
        }
        catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                              "could createe the Directories to upload and download");
        }
    }

     public String storeFile(Integer id,MultipartFile file){
        //file is coming in the request which we need to add in uploads
        java.nio.file.Path destinationFile =this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
        
        try{
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream,destinationFile,StandardCopyOption.REPLACE_EXISTING);

        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Could not save File");

        }
    
    //create the url that will be used to download the file and we will updating to all products.
    //ServletUriComponentsBuilder to provide http://localhost:8080

    String uploadedFileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                              .path("/products/download")
                              .path(file.getOriginalFilename())
                              .toUriString();

        Product product = this.repository.findById(id).get();
        product.setId(id);
        product.setImageUrl(uploadedFileUrl);
        this.repository.save(product);                      
        return "Files upload sucessfully";
     }

     public org.springframework.core.io.Resource downloadFile(String filename){
        java.nio.file.Path file= rootLocation.resolve(filename);
        try{
        org.springframework.core.io.Resource resource = new UrlResource(file.toUri());
            return  resource;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                              "could not download the file");
        }
     }
    


//     private Map<Integer,product> productMap = new HashMap<>(); //to store data into database as a temporary.this is collection.of my class.
//     //collection that will contains the product  objects,resource,documents
//     private AtomicInteger atomic = new AtomicInteger(); //for id wants to be unique.this class will used. that can be used for {id} for products.
// //atomic integer class is used to generate the unique value that can be used for the id of the product.
//     // public ProductService(){//this is constructor of product service class.
//     //     product product1 = new product();//product resource
//     //     product1.setId(atomic.incrementAndGet());
//     //     product1.setName("doggy");
//     //     product1.setPrice(45000.58);
//     //     product1.setDescription("this is for doggy");
//     //     productMap.put(product1.getId(),product1);


//     //     product product2 = new product();
//     //     product2.setId(atomic.incrementAndGet());
//     //     product2.setName("saddy");
//     //     product2.setPrice(48000.58);
//     //     product2.setDescription("this is for paggy baccha");
//     //     productMap.put(product2.getId(),product2);
//    // }


//        // public Collection<product> getproducts(){
//             //return productMap.values(); //return product map my database values
//             //Reading all records
//             public Iterable<product>getproducts(){
//                 return repository.findAll();
//             }


//         // public String add(product p){
//         //     p.setId(atomic.incrementAndGet());
//         //     productMap.put(p.getId(), p);
//         //     return "product object added sucessfully";
//         //inserting new Records
//         public product add(product p){
//             return repository.save(p);
//         }
//          //Reading single records
//         public product getProductByID(Integer id){
//         //     product found = productMap.get(id);
//         //     if (found!=null)
//         //     return found;
//         //     else
//         //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"product of this id dowes not exists");
//                return repository.findById(id).orElse(null);

//         }
//         //Delete single Records
//         public String deleteProduct(Integer id){
//            // getProductByID(id); //checking if the records exists or not 
//             //productMap.remove(id);
//             repository.deleteById(id);
//             return "Product object deleted sucessfully";

//         }

//         // public String updateProduct(Integer id,product p){
//         //     getProductByID(id);
//         //     p.setId(id);
//         //     productMap.put(id, p);
//         //     return "Product object Updated sucessfully";
//         //Updating single Records
//         public product updateProduct(Integer id,product p){
//             p.setId(id);
//             return repository.save(p);


//         }






}


