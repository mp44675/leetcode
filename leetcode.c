#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
//struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2);


struct ListNode {
    int val;
    struct ListNode *next;
};
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *ret = NULL;
    ret = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode *head1 = l1;
    struct ListNode *head2 = l2;
    struct ListNode *ret_traverser = ret;
    bool carry = false;
    int sum = 0;
    while (head1->next != NULL || head2->next != NULL) {
        sum = head1->val + head2->val;
        if (carry == true) {
            sum++;
            carry = false;
        } 
        if (sum >= 10) {
            carry = true;
            sum = sum - 10;
        }
        
        struct ListNode *next = NULL;
        next = (struct ListNode*) malloc(sizeof(struct ListNode));
        next->val = sum;
        next->next = NULL;
        ret = next;
        ret_traverser->next = NULL;
        ret_traverser = next;
        if (head1->next != NULL) {
            head1 = head1 -> next;
        }
        if (head2->next != NULL) {
            head2 = head2 -> next;
        }
    }
    if (carry == true) {
        carry = false;
        ret_traverser->val = 1;
    }
 
    
    return ret;
}


struct zig {
    int row;
    char let;
    struct zig *next;
};


char * convert(char * s, int numRows){

    struct zig *z = NULL;
    z = (struct zig*) malloc(sizeof(struct zig));
    struct zig *trav = z;
    int curr_row = 1;
    int pos = 0;
    bool reverse = false;
    while (s[pos] != NULL) {
        //if pos == 0 then make the head the firs thing
        if (curr_row != numRows + 1 && reverse == false) {
            struct zig *new = NULL;
            new = (struct zig*) malloc(sizeof(struct zig));
            new->row = curr_row;
            new->let = s[pos];
            new->next = NULL;
            trav = new;
            pos++;
            curr_row++;
            printf("%c%d ", new->let, new->row);
        } else if (curr_row != 0 && reverse == true) {
            struct zig *new = NULL;
            new = (struct zig*) malloc(sizeof(struct zig));
            new->row = curr_row;
            new->let = s[pos];
            new->next = NULL;
            z->next = new;
            trav = new;
            pos++;
            curr_row--; 
            printf("%c%d ", new->let, new->row);
        } else if (curr_row == numRows+1) {
            curr_row-=2;
            reverse = true;
            continue;
        } else if (curr_row == 0) {
            curr_row+=2;
            reverse = false;
            continue;
        }

    }

}

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int *ret;
    ret = (int *)malloc (2 * sizeof(int));
    bool sol_found = false;
    for (int i = 0; i < numsSize; i++ ) {
        for (int j = i+1; j < numsSize ; j++) {
            if ( *(nums+i) + *(nums+j) == target) {
                *ret = i;
                *(ret+1) = j;
                return ret;
            }
        }
    }
    return NULL;
}


bool judgeSquareSum (int c) {
    bool found = false;
    int sum = 0;
    for (long a = 0; a*a <= c; a++) {
        for (long b = 0; b*b <= c; b++) {
            if ((a*a) + (b*b) == c) {
                return true;
            }
        }
    }
    return false;
}

char * multiply(char * num1, char * num2){
    int int_num1 = atoi(num1);
    int int_num2 = atoi(num2);
    
    int res = int_num1 * int_num2;
    char *c = (char *) malloc(1*sizeof(char));
    sprintf(c, "%d", res);
    return c;
}

void sortColors(int* nums, int numsSize){
    quicksort(&nums, 0, numsSize-1);
}

void quicksort (int **nums, int low, int high) {
    if (low < high) {
        int q;
        q = partition (*nums, low, high);
        quicksort(*nums, low, q-1);
        quicksort(*nums, q+1, high);
    }
}

int partition (int *nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;
    for (int j = low; j < high-1; j++) {
        if (nums[j] < pivot) {
            i++;
            swap(nums[i], nums[j]);
        }
    }
    //swap(*nums[i+1], *nums[high]);
    return i+1;
}

void swap (int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}


int minCostClimbingStairs(int* cost, int costSize){
    
    //start at 0 or 1
    //can take either 1 or two steps
    int sum = cost[0];
    int i = 1;
    while (i < costSize) {
        //start at 0
        if ( (i+1) != costSize) {
            if (sum+cost[i] < sum+cost[i+1]) {
                sum += cost[i];
                i++;
                continue;
            } else if (sum+cost[i] == sum+cost[i+1]) {
                sum += cost[i+1];
                i+=2;
                continue;
            } else {
                sum += cost[i+1];
                i+=2;
                continue;
            }
        }
        i++;
    }
    
    int sum1 = cost[1];
    i = 2;
    while (i < costSize) {
        //start at 0
        if ((i+1) != costSize) {
            if (sum1+cost[i] < sum1+cost[i+1]) {
                sum1 += cost[i];
                i++;
                continue;
            } else if (sum1+cost[i] == sum1+cost[i+1]) {
                sum1 += cost[i+1];
                i+=2;
                continue;
            } else {
                sum1 += cost[i+1];
                i+=2;
                continue;
            }
        }
    }
    
    if (sum < sum1) {
        return sum;
    } else {
        return sum1;
    }

}

int removeElement(int* nums, int numsSize, int val){
    int *mod_nums = (int *) malloc(numsSize * sizeof(int));
    //fill modnums with numbers that aren't val
    int res = 0;
    int mod_nums_count = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            mod_nums[mod_nums_count] = nums[i];
            mod_nums_count++;
        } else {
            // if it is val then res increments
            res++;
        }
    }
    
    for (int j = 0; j < numsSize-res; j++) {
        nums[j] = mod_nums[j];
    }
    return numsSize - res;
    
}

int main () {
    int *nums = (int *)malloc (9 * sizeof(int));
    nums[0] = 0;
    nums[1] = 1;
    nums[2] = 2;
    nums[3] = 2;
    nums[4] = 3;
    nums[5] = 0;
    nums[6] = 4;
    nums[7] = 2;
    removeElement(nums, 8, 2);

}