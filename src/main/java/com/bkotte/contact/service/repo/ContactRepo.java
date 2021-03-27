package com.bkotte.contact.service.repo;

import com.bkotte.contact.service.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, String> {
}
