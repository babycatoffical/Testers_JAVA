import {createSlice} from "@reduxjs/toolkit";

const counteInitState = { counter: 0, showCounter: true };
const counterSlice = createSlice({
    name: "counter",
    initialState: counteInitState,
    reducers: {
        increment(state) {
            state.counter++;
        },
        increase(state, action) {
            state.counter = state.counter + action.payload;
        },
        decrement(state) {
            state.counter--;
        },
        toggleCounter(state) {
            state.showCounter = !state.showCounter;
        },
    },
});

export default counterSlice;