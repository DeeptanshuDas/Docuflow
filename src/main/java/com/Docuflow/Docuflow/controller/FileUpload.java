package com.Docuflow.Docuflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUpload {

    // Define the directory where uploaded files will be stored
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/uploadStatus";
        }

        try {
            // Get the file's bytes
            byte[] bytes = file.getBytes();

            // Define the target path for the uploaded file
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

            // Create the directory if it doesn't exist
            Files.createDirectories(path.getParent());

            // Write the bytes to the file system
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
            redirectAttributes.addFlashAttribute("message", "Failed to upload file: " + e.getMessage());
        }

        return "redirect:/uploadStatus";
    }
}
// public class FileUpload {

// }
