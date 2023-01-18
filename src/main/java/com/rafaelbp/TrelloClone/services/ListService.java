package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.exceptions.ListNotFoundException;
import com.rafaelbp.TrelloClone.models.ListModel;
import com.rafaelbp.TrelloClone.repositories.ListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService implements IListService {
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public List<ListModel> getAllList() {
        return this.listRepository.findAll();
    }

    @Override
    public ListModel getList(Long id) {
        ListModel list = this.listRepository.findById(id)
                .orElseThrow(() -> new ListNotFoundException());
        return list;
    }

    @Override
    public ListModel addList(ListModel list) {
        ListModel newList = this.listRepository.save(list);
        return newList;
    }

    @Override
    @Transactional
    public ListModel updateList(Long id, ListModel reqList) {
        ListModel list = this.getList(id);
        String newTitle = reqList.getTitle();
        String newDescription = reqList.getDescription();

        if (newTitle != null) list.setTitle(newTitle);
        if (newDescription != null) list.setDescription(newDescription);

        return list;
    }

    @Override
    public void deleteList(Long id) {
        ListModel list = this.getList(id);
        this.listRepository.delete(list);
    }
}
