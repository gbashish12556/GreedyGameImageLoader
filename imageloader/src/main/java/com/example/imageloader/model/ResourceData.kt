package com.example.imageloader.model

import java.io.Serializable;

interface ResourceData<T>: Serializable {
    fun get():T
}