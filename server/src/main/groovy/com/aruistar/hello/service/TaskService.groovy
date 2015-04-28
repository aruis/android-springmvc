package com.aruistar.hello.service

import com.aruistar.hello.domain.Task
import org.springframework.stereotype.Repository

/**
 * Created by liurui on 15/4/27.
 */
@Repository
class TaskService {

    List tasks

    def init() {
        tasks = []

        4.times {
            def i = it + 1
            tasks.add(new Task(imgUrl: "/images/${i}.jpg", name: "任务$i", detail: "这是详细信息$i"))
        }
    }

    def list() {
        tasks
    }

}
