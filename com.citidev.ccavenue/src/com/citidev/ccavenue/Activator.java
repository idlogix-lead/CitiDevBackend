package com.citidev.ccavenue;

import org.adempiere.base.Core;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Core.getMappedProcessFactory().scan(bundleContext, "com.citidev.ccavenue.processes");
		Core.getMappedModelFactory().scan(bundleContext, "com.citidev.ccavenue.models");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
