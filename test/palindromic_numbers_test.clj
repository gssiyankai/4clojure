(ns palindromic_numbers_test
  (:use clojure.test)
  (:use palindromic_numbers))

(deftest test-1
  (is (= (take 26 (pal-num 0))
          [0 1 2 3 4 5 6 7 8 9
           11 22 33 44 55 66 77 88 99
           101 111 121 131 141 151 161])))

(deftest test-2
  (is (= (take 16 (pal-num 162))
         [171 181 191 202
          212 222 232 242
          252 262 272 282
          292 303 313 323])))

(deftest test-3
  (is (= (take 6 (pal-num 1234550000))
         [1234554321 1234664321 1234774321
          1234884321 1234994321 1235005321])))

(deftest test-4
  (is (= (first (pal-num (* 111111111 111111111)))
         (* 111111111 111111111))))

(deftest test-5
  (is (= (set (take 199 (pal-num 0)))
        (set (map #(first (pal-num %)) (range 0 10000))))))

(deftest test-6
  (is (= true
        (apply < (take 6666 (pal-num 9999999))))))

(deftest test-6
  (is (= (nth (pal-num 0) 10101)
         9102019)))


(run-tests 'palindromic_numbers_test)