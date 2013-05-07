/*******************************************************************************
* Copyright (c) 2013 Aroma1997.
* All rights reserved. This program and other files related to this program are
* licensed with a extended GNU General Public License v. 3
* License informations are at:
* https://github.com/Aroma1997/CompactWindmills/blob/master/license.txt
******************************************************************************/
package aroma1997.compactwindmills;

import com.google.common.base.Throwables;
/**
 * 
 * @author Aroma1997
 *
 */
public enum WindType {
	ELV(8, "Ultra Low Voltage Windmill", TileEntityWindmill.class, 3),
	LV(32, "Low Voltage Windmill", TileEntityWindmill.class, 6),
	MV(128, "Medium Voltage Windmill", TileEntityWindmill.class, 8),
	HV(512, "High Voltage Windmill", TileEntityWindmill.class, 10),
	EV(2048, "Extreme Voltage Windmill", TileEntityWindmill.class, 12);

	public int output;
	public Class<? extends TileEntityWindmill> claSS;
	public String showedName;
	public int checkRadius;

	private WindType(int output, String showedName, Class<? extends TileEntityWindmill> claSS, int checkRadius) {
		this.output = output;
		this.showedName = showedName;
		this.claSS = claSS;
		this.checkRadius = checkRadius;
	}

	public static TileEntityWindmill makeTileEntity(int metadata) {
		int windtype = metadata;
		try {
			TileEntityWindmill tileEntity = values()[windtype].claSS.getConstructor(WindType.class).newInstance(values()[windtype]);
			//TileEntityWindmill tileEntity = values()[windtype].claSS.newInstance();
			return tileEntity;
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public String tileEntityName() {
		return "WindType." + name();
	}

}
