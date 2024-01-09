package com.test.cliente.domain.service.utils;

public enum Domains {
	USA("cidenet.com.us"),
	COL("cidenet.com.co");
	
	public final String domain;

    private Domains(String domain) {
        this.domain = domain;
    }
}
