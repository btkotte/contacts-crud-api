package com.bkotte.contact.service.api;

import com.bkotte.contact.service.model.Contact;
import com.bkotte.contact.service.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactApi {

    private final ContactRepo contactRepo;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    @GetMapping("/{email}")
    public Contact getContact(@PathVariable String email) {
        return contactRepo.findById(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with this email"));
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        Contact existing = contactRepo.findById(contact.getEmail()).orElse(null);
        if (existing != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        return contactRepo.save(contact);
    }

//    @PutMapping("/{email}")
//    public Contact updateContact(@PathVariable String email, Contact updatedContact){
//        Contact contact = contactRepo.findById(email)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with this email"));
//
//        return contactRepo.save(contact);
//    }

    @DeleteMapping("/{email}")
    public void deleteContact(@PathVariable String email) {
        contactRepo.findById(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with this email"));
        contactRepo.deleteById(email);
    }
}
