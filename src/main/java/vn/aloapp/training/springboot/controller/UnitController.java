package vn.aloapp.training.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.UnitEntity;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDUnitRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.MaterialCategory.UnitResponse;
import vn.aloapp.training.springboot.service.UnitsService;

@RestController
@RequestMapping("/api/units")
public class UnitController extends BaseController {
	@Autowired
	private UnitsService unitService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createUnit(@RequestHeader("Authorization") String token,
			@RequestBody CRUDUnitRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		UnitEntity unit = unitService.spUCreateUnit(user.getId(), w.getName(), w.getDescription());
		response.setData(new UnitResponse(unit));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateUnit(@RequestBody CRUDUnitRequest w,
			@RequestHeader("Authorization") String token, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		UnitEntity unitEntity = unitService.findById(id);

		if (unitEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy đơn vị");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		UnitEntity unitEntityDuplicate = unitService.findByName(w.getName());
		if (unitEntityDuplicate != null && unitEntityDuplicate.getId() != id) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Đơn vị đã tồn tại");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		UnitEntity unit = unitService.spUpdateUnit(id, user.getId(), w.getName(), w.getDescription());
		response.setData(new UnitResponse(unit));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<UnitResponse> getAll() throws Exception {
		List<UnitEntity> list = unitService.findAll();
		List<UnitResponse> listReponse = new UnitResponse().mapToList(list);
		return listReponse;
	}

	@RequestMapping(value = "/{id}/find-id", method = RequestMethod.GET)
	public UnitResponse findById(@PathVariable("id") int id) throws Exception {
		UnitEntity unitEntity = unitService.findById(id);
		return new UnitResponse(unitEntity);
	}

	@RequestMapping(value = "/{id}/update-status", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateStatus(@Valid @RequestParam(name = "status") int status,
			@RequestHeader("Authorization") String accessToken, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(accessToken);
		unitService.updateStatusUnit(id, status);
		UnitEntity unit = unitService.findById(id);
		response.setData(new UnitResponse(unit));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
