package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.models.ListModel;

import java.util.List;


public interface IListService {
    List<ListModel> getAllList();
    ListModel getList(Long id);
    ListModel addList(ListModel list);
    ListModel updateList(Long id, ListModel list);
    void deleteList(Long id);
}
