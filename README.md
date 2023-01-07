# Fine Tune GPT3 for Code

The dataset is in [./dataset.csv](./dataset.csv).

## Install and Setup

```shell
npm install
```

You can store the api key in a `.env` file:

```
OPENAI_API_KEY="YOUR_OPENAI_API_KEY_GOES_HERE"
```

## Running the Code

```shell
# Upload the dataset and create the fine-tuned model
node index.js

# List the status of the fine-tuning until the fine_tune_model field is no longer null
node index.js list

# Use the fine tune id as the model
node index.js model-finetune-id prompt
```

Example session:

```
$ node index.js
Fine tune id: id-123

$ node index.js list
ft-nlBqfegq5AP1QkfLKOCvuz6u succeeded curie:ft-personal-2023-01-07-06-54-13
ft-l8B3FiHivRuMWxj8U1YvQKq2 running null

$ node index.js curie:ft-personal-2023-01-07-06-54-13 "define apply effect"
const yEff = (value) => ({ done: false, value })

$ node index.js curie:ft-personal-2023-01-07-06-54-13 "test api call saga"
function* fetchProducts() {
  const products = yield call(Api

$ node index.js curie:ft-personal-2023-01-07-06-54-13 "test api call saga"
assert.deeplyEqual(
  iterator.next().value,

$ node index.js list
ft-nlBqfegq5AP1QkfLKOCvuz6u succeeded curie:ft-personal-2023-01-07-06-54-13
ft-l8B3FiHivRuMWxj8U1YvQKq2 succeeded davinci:ft-personal-2023-01-07-07-00-01

$ node index.js davinci:ft-personal-2023-01-07-07-00-01 "define apply effect"
const arrayOfValues = { value: 5 }
  const expectedEffect =

$ node index.js davinci:ft-personal-2023-01-07-07-00-01 "test api call saga"
assert.deepEqual(
import { cps } from 'redux

$ node index.js davinci:ft-personal-2023-01-07-07-00-01 "test api call saga"
assert.deepEqual(
  iterator.next(assert.isNot
```
