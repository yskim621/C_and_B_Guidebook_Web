package gmail.yskim62100.c_and_b_guidebook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gmail.yskim62100.c_and_b_guidebook.service.BoardtblService;
import gmail.yskim62100.c_and_b_guidebook.service.GametblService;

@RestController
public class GametblRestController {
	@Autowired
	private GametblService gametblService;

}
