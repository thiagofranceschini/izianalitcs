package br.com.izifinance.izianalyse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.izifinance.izianalyse.model.Register;
import br.com.izifinance.izianalyse.model.StatusRegister;
import br.com.izifinance.izianalyse.services.AproveAndReproveService;

@RestController
@RequestMapping("analyses")
public class AnalyseController {

	@Autowired
	private AproveAndReproveService service;

	@GetMapping("status/{status}")
	public ResponseEntity<?> listRegister(@PathVariable StatusRegister status,
			@PageableDefault(sort = "registerDate", direction = Sort.Direction.ASC) Pageable pageRequest) {
		Page<Register> page = service.getPageByStatus(status, pageRequest);
		return ResponseEntity.ok().body(page);
	}

	@PostMapping("authorize/{registerId}")
	public ResponseEntity<?> authorizeRegister(@PathVariable String registerId) {
		Register authorized = service.changeStatusRegisterToAuthorized(registerId);
		return ResponseEntity.ok().body(authorized);
	}

	@PostMapping("reprove/{registerId}")
	public ResponseEntity<?> reproveRegister(@PathVariable String registerId) {
		Register reproved = service.changeStatusRegisterToNotAllowed(registerId);
		return ResponseEntity.ok().body(reproved);
	}

}
