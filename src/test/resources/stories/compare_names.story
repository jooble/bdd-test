Scenario: compare name of headphones a manufacturer Samsung

Given a yandex page
When i open yandex market
When i open subsection as Электроника
When i click on the Мобильные телефоны in Телефоны
When i enter manufacturer as Samsung
When i enter price from as 40000
Then i want compare names of first product and name in product card

Scenario: compare name of phones a manufacturer Beats

Given a yandex page
When i open yandex market
When i open subsection as Электроника
When i click on the Наушники и Bluetooth-гарнитуры in Телефоны
When i enter manufacturer as Beats
When i enter price from as 17000
When i enter price to as 25000
Then i want compare names of first product and name in product card