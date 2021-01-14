package com.kromemedia.mediaapi.contollers;

import com.kromemedia.mediaapi.models.MediaAsset;
import com.kromemedia.mediaapi.services.MediaAssetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/mediaAsset")
public class MediaAssetController {
    private final MediaAssetService service;

    @Autowired
    public MediaAssetController(MediaAssetService service) {
        this.service = service;
    }

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<Collection<MediaAsset>> findAll() {
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(service.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<MediaAsset>> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(service.findById(id), headers, HttpStatus.OK);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<MediaAsset> create(@RequestBody MediaAsset options) throws Exception {
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(service.create(options), headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<MediaAsset> update(
            @PathVariable Integer id, @RequestBody MediaAsset changes
    ) throws Exception {

        changes.setId(id);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(service.update(changes), headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<SimpleMessage> delete(@PathVariable Integer id) throws Exception {

        this.service.delete(id);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(new SimpleMessage("ok", null), headers, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SimpleMessage> localExceptionHandler(Exception e) {

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(new SimpleMessage("local", e.getMessage()), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
