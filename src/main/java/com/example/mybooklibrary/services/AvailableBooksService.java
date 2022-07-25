package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.AvailableBooks;
import com.example.mybooklibrary.repositories.AvailableBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableBooksService {
    @Autowired
    private AvailableBooksRepository availableBooksRepository;
    public List<AvailableBooks> getAvailableBooks() {
        return availableBooksRepository.findAll();
    }
}
// caut cartea aici, o mut in borrowed, o sterg de aici si o sa aiba "returnDate" cand va fi available iara.
// cand faci rent la o carte -> folosesti request param/path variable (userId) care vrea sa imprumute cartea
//cauti cartea in available -> o stergi din available -> o pui in borrowed cu userId care a imprumutat-o si userId + bookId care o detine