package io.iykat.wordsearchapi.controller;

import io.iykat.wordsearchapi.services.WordGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/wordgrid")
public class WordSearchController {

    final
    WordGridService wordGridService;

    public WordSearchController(WordGridService wordGridService) {
        this.wordGridService = wordGridService;
    }

    @GetMapping
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:1234")
    public String createWordGrid(@RequestParam("gridSize") int gridSize, @RequestParam String wordList) {
        List<String> words = Arrays.asList(wordList.split(","));
        char[][] grid = wordGridService.generateGrid(gridSize, words);
        String gridToString = "";
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridToString += grid[i][j] + " ";
            }
            gridToString += "\r\n";
        }
        return gridToString;
    }

}
