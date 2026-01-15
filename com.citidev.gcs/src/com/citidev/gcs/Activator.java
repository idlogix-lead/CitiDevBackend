package com.citidev.gcs;

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
		Core.getMappedProcessFactory().scan(bundleContext, "com.citidev.gcs.processes");
		Core.getMappedModelFactory().scan(bundleContext, "com.citidev.gcs.models");
		}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
