#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    vector<vector<int>> res;
    int sum = target;
    for (int i = 0; i < candidates.size(); i++) {
        bool found = false;
        vector<int> v;
        vector<int> v2;
        sum = target;
        if (candidates[i] == target) {
            v.push_back(candidates[i]);
            res.push_back(v);
            continue;
        }
        while (sum != 0) {
            if (!(sum - candidates[i] < 0)) {
                sum = sum - candidates[i];
                v.push_back(candidates[i]);
            } else {
                break;
            }
            if (find(candidates.begin(), candidates.end(), sum) != candidates.end()) {
                // if a candidate exists that allows it to reach zero
                v.push_back(sum);
                res.push_back(v);
                found = true;
                break;
            }
        }
    }
    return res;
}

int main(int argc, char *argv[]) {
    vector<int> candidates {2, 3, 5};
    vector<vector<int>> res = combinationSum(candidates, 8);

}