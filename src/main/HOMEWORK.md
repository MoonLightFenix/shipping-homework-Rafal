# Assignment

## Introduction
Imagine you are running an e-shop here at wix. You're selling various lifestyle items from clothing, to footwear, to
accessories. Each item sold has to be shipped and your clients can choose from a list of shipping providers. Items are
assigned to different size categories which also impacts the shipping price.

Shipping prices

| Provider     | Size         | Price  |
|--------------|--------------|--------|
| OM           | S            | 1 €    |
| OM           | L            | 7.20 € |
| DH           | S            | 0.90 € |
| DH           | M            | 3.40 € |
| LP           | S            | 1.23 € |
| LP           | M            | 3 €    |
| LP           | L            | 7 €    |

## Step 1
Your first task is to create an application that will calculate shipping prices.

Your input is going to be a text file where each line represents a purchased item. It will also contain purchase date
and shipping provider selected by the customer. E.g.
```
2021-06-12 S OM
2021-07-13 L LP
2021-07-14 M DH
```

Your program should accept this file as input and print out the same lines with the shipping price included.

```
2021-06-12 S OM 1
2021-07-13 L LP 7
2021-07-14 M DH 3.40
```

If any lines contain invalid data (e.g. bad date or unknown shipping provider) the program should ignore that line and
print our ERROR next to it.
e.g. ``2021-06-14 M OM ERROR``