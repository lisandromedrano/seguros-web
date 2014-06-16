package com.lix.pagos.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lix.csv.PagosParserEntity;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.util.BeanUtils;

public class PagosBuilder {
	private final static Logger LOGGER = LoggerFactory
			.getLogger(PagosBuilder.class);
	private List<PagosCompanias> pagosCompanias;
	private List<PagosPolizas> pagosPolizas;

	public PagosBuilder(List<PagosParserEntity> pagos) {
		pagosCompanias = new ArrayList<PagosCompanias>();
		pagosPolizas = new ArrayList<PagosPolizas>();
		for (PagosParserEntity p : pagos) {
			try {
				if (Pagos.TIPO_PAGO_COMPANIA.equals(p.getTipoPago())) {
					if (p.getCompanias() == null) {
						LOGGER.error(
								"Datos inconsistentes, pago de compania no tiene compania asignada:{}",
								p);
					} else {
						pagosCompanias.add(BeanUtils.copyProperties(p,
								PagosCompanias.class));

					}
				}
				if (Pagos.TIPO_PAGO_POLIZA.equals(p.getTipoPago())) {
					if (p.getPolizas() == null
							|| p.getPolizas().getId() == null) {
						LOGGER.error(
								"Datos inconsistentes, pago de poliza no tiene poliza asignada:{}",
								p);
					} else {
						pagosPolizas.add(BeanUtils.copyProperties(p,
								PagosPolizas.class));

					}

				}
			} catch (Exception e) {
				LOGGER.error("Error converting pago:{},{}", p, e.getMessage());
			}
		}
	}

	public List<PagosCompanias> getPagosCompanias() {
		return pagosCompanias;
	}

	public void setPagosCompanias(List<PagosCompanias> pagosCompanias) {
		this.pagosCompanias = pagosCompanias;
	}

	public List<PagosPolizas> getPagosPolizas() {
		return pagosPolizas;
	}

	public void setPagosPolizas(List<PagosPolizas> pagosPolizas) {
		this.pagosPolizas = pagosPolizas;
	}

}
