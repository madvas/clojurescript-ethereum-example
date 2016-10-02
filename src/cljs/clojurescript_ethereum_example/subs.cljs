(ns clojurescript-ethereum-example.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :db/my-addresses
  (fn [db]
    (:my-addresses db)))

(reg-sub
  :db/tweets
  (fn [db]
    (sort-by :date #(compare %2 %1) (:tweets db))))

(reg-sub
  :db/new-tweet
  (fn [db]
    (:new-tweet db)))

(reg-sub
  :db/settings
  (fn [db]
    (:settings db)))

(reg-sub
  :new-tweet/selected-address-balance
  (fn [db]
    (get-in db [:accounts (:address (:new-tweet db)) :balance])))
