package com.citidev.infinity;

import org.adempiere.base.Core;
import org.adempiere.plugin.utils.Incremental2PackActivator;
import org.compiere.util.CLogger;
import org.osgi.framework.BundleContext;

public class Activator extends Incremental2PackActivator {

    private static final CLogger log = CLogger.getCLogger(Activator.class);

	public void start(BundleContext bundleContext) throws Exception {
        log.info("<----------------------------- Starting CitiDev Infinity Plugin ----------------------------->");
		super.start(bundleContext);
		Core.getMappedProcessFactory().scan(bundleContext, "com.citidev.infinity.processes");
		Core.getMappedModelFactory().scan(bundleContext, "com.citidev.infinity.models");
	}

	@Override
	protected void afterPackIn() {
		// TODO Auto-generated method stub
        log.info("<----------------------------- PackIn Activator Executed ------------------------------------->");
		super.afterPackIn();
		context.registerService(Activator.class, this, null);
	}

}