package com.example.randomusers.utils

import com.example.randomusers.model.datalayer.Name

/**
 * @author: tonghann.teng
 * @since: 8/1/23
 */
fun Name.getUserName(): String {
    return "${this.title} ${this.first} ${this.last}"
}
