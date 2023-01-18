package com.rafaelbp.TrelloClone.controllers;

import com.rafaelbp.TrelloClone.models.ListModel;
import com.rafaelbp.TrelloClone.services.ListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/list")
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }


    @GetMapping
    public List<ListModel> getAllList() {
        return this.listService.getAllList();
    }

    @GetMapping("/{id}")
    public ListModel getList(
            @PathVariable Long id
    ) {
        return this.listService.getList(id);
    }

    @PostMapping
    public ListModel addList(
            @RequestBody ListModel reqList
    ) {
        return this.listService.addList(reqList);
    }

    @PutMapping("/{id}")
    public ListModel updateList(
            @PathVariable Long id,
            @RequestBody ListModel reqList
    ) {
        return this.listService.updateList(id, reqList);

    }

    @DeleteMapping("/{id}")
    public void deleteList(
            @PathVariable Long id
    ) {
        this.listService.deleteList(id);
    }
}
