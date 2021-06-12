package jimmy.mobilepos.data.models

import jimmy.mobilepos.ui.settings.PaymentMethods

class Transaction(val method: PaymentMethods, val card: String, val amount: String)