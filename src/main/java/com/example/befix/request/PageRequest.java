package com.example.befix.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {
    int page = 1;

    int size = 8;
}
