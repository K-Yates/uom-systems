/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package systems.uom.common.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Priority;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

import systems.uom.common.Imperial;
import systems.uom.common.US;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.1, March 20, 2016
 */
@Priority(100)
public class CommonSystemService implements SystemOfUnitsService {
	
	final Map<String, SystemOfUnits> souMap = new HashMap<String, SystemOfUnits>();

	public CommonSystemService() {
		souMap.put("Imperial", Imperial.getInstance());
		souMap.put("US", US.getInstance());
	}
	
	public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
		return souMap.values();
	}
	
	@Override
	public SystemOfUnits getSystemOfUnits() {
		return getSystemOfUnits("US"); // We assume US Customary as the more common system here
	}

	@Override
	public SystemOfUnits getSystemOfUnits(String name) {
		return souMap.get(name);
	}
}