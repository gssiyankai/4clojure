(ns tricky_card_game_test
  (:use clojure.test)
  (:use tricky_card_game))

(deftest test-1
  (is (let [notrump (solve nil)]
        (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                                 {:suit :club :rank 9}]))
             (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                 {:suit :club :rank 10}]))))))

(deftest test-2
  (is (= {:suit :club :rank 10} ((solve :club) [{:suit :spade :rank 2}
                                                {:suit :club :rank 10}]))))

(deftest test-3
  (is (= {:suit :heart :rank 8}
         ((solve :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                          {:suit :diamond :rank 10} {:suit :heart :rank 4}]))))

(run-tests 'tricky_card_game_test)