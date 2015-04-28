package com.aruistar.hello.controller

import com.aruistar.hello.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by liurui on 15/4/27.
 */
@RestController
class TaskController {

    @Autowired
    TaskService taskService

    @RequestMapping("/task/list")
    List task() {
        taskService.init()
        taskService.list()
    }
}
