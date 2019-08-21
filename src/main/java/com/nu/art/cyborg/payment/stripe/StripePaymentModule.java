/*
 * Copyright (c) 2017 to Adam van der Kruk (Zehavi) AKA TacB0sS - Nu-Art Software
 *
 * This software code is not an 'Open Source'!
 * In order to use this code you MUST have a proper license.
 * In order to obtain a licence please contact me directly.
 *
 * Email: adam.vdk@nu-art-software.com
 */

package com.nu.art.cyborg.payment.stripe;

import com.nu.art.cyborg.payment.PaymentModule;
import com.nu.art.core.exceptions.runtime.BadImplementationException;
import com.nu.art.cyborg.annotations.ModuleDescriptor;
import com.stripe.android.Stripe;
import com.stripe.exception.AuthenticationException;

/**
 * Created by TacB0sS on 22-Aug 2016.
 */

@ModuleDescriptor
public class StripePaymentModule
	extends PaymentModule {

	private String stripeKey;
	private Stripe stripe;

	@Override
	protected void init() {
		try {
			stripe = new Stripe(stripeKey);
		} catch (AuthenticationException e) {
			throw new BadImplementationException(e.getMessage() + " Stripe manager failed to initialized...");
		}
		logDebug("Strip successfully authenticated...");
	}

	public void setStripeKey(String stripeKey) {
		this.stripeKey = stripeKey;
	}
}
