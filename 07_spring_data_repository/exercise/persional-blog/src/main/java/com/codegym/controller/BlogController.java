package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "/blog/create";
    }

    @PostMapping({"/create-blog"})
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blog.setStartTime(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog created successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/blogs")
    public String listBlogs(@PageableDefault(value = 3, sort = "startTime",direction = Sort.Direction.DESC)Pageable pageable, Model model) {
        Page<Blog> blogs = blogService.findAll(pageable);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("/edit-blog/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping({"/edit-blog"})
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blog.setStartTime(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/delete-blog/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:/blogs";
    }

    @GetMapping("/view-blog/{id}")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Blog> blogs = blogService.findByName(name);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
}
